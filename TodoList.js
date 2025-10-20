import React, { useEffect, useState } from 'react';

const TodoList = () => {
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch('https://jsonplaceholder.typicode.com/todos')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        setTodos(data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message || 'Something went wrong');
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading todos...</p>;
  if (error) return <p style={{ color: 'red' }}>Error: {error}</p>;

  return (
    <div style={{ maxWidth: 600, margin: '20px auto', fontFamily: 'Arial, sans-serif' }}>
      <h2>Todo List</h2>
      <ul style={{ listStyleType: 'none', padding: 0 }}>
        {todos.map((todo) => (
          <li
            key={todo.id}
            style={{
              backgroundColor: todo.completed ? '#d4edda' : '#f8d7da',
              marginBottom: '10px',
              padding: '10px',
              borderRadius: '5px',
              border: '1px solid',
              borderColor: todo.completed ? '#c3e6cb' : '#f5c6cb',
              color: todo.completed ? '#155724' : '#721c24',
              display: 'flex',
              alignItems: 'center',
            }}
          >
            <input
              type="checkbox"
              checked={todo.completed}
              readOnly
              style={{ marginRight: '10px' }}
            />
            <span>{todo.title}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TodoList;
