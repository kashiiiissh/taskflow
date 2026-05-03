import { useEffect, useState } from "react";
import API from "../services/api";
import { useNavigate } from "react-router-dom";

const Tasks = () => {
  const [tasks, setTasks] = useState<any[]>([]);
  const [title, setTitle] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const res = await API.get("/tasks");
      setTasks(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const addTask = async () => {
    if (!title) return;

    try {
      const res = await API.post("/tasks", { title });
      setTasks([...tasks, res.data]);
      setTitle("");
    } catch (err) {
      console.error(err);
    }
  };

  const deleteTask = async (id: number) => {
    await API.delete(`/tasks/${id}`);
    setTasks(tasks.filter((t) => t.id !== id));
  };

  const logout = () => {
    localStorage.removeItem("token");
    navigate("/");
  };

  return (
    <div style={styles.container}>
      
      {/* Header */}
      <div style={styles.header}>
        <h2>📝 Task Manager</h2>
        <button onClick={logout} style={styles.logoutBtn}>
          Logout
        </button>
      </div>

      {/* Add Task */}
      <div style={styles.addBox}>
        <input
          style={styles.input}
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="Enter new task..."
        />
        <button onClick={addTask} style={styles.addBtn}>
          Add
        </button>
      </div>

      {/* Task List */}
      <div style={styles.list}>
        {tasks.length === 0 ? (
          <p>No tasks yet 😅</p>
        ) : (
          tasks.map((task) => (
            <div key={task.id} style={styles.card}>
              <span>{task.title}</span>
              <button
                onClick={() => deleteTask(task.id)}
                style={styles.deleteBtn}
              >
                Delete
              </button>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default Tasks;

const styles = {
  container: {
    maxWidth: "500px",
    margin: "40px auto",
    fontFamily: "Arial",
  },

  header: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
  },

  logoutBtn: {
    padding: "6px 12px",
    background: "red",
    color: "white",
    border: "none",
    borderRadius: "6px",
    cursor: "pointer",
  },

  addBox: {
    display: "flex",
    marginTop: "20px",
    gap: "10px",
  },

  input: {
    flex: 1,
    padding: "10px",
    borderRadius: "6px",
    border: "1px solid #ccc",
  },

  addBtn: {
    padding: "10px 16px",
    background: "#4CAF50",
    color: "white",
    border: "none",
    borderRadius: "6px",
    cursor: "pointer",
  },

  list: {
    marginTop: "20px",
  },

  card: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    padding: "12px",
    border: "1px solid #ddd",
    borderRadius: "8px",
    marginBottom: "10px",
    background: "#f9f9f9",
  },

  deleteBtn: {
    background: "crimson",
    color: "white",
    border: "none",
    padding: "6px 10px",
    borderRadius: "6px",
    cursor: "pointer",
  },
};