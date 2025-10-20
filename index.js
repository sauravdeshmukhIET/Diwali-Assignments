const express = require('express');
const bodyParser = require('body-parser');
const db = require('./db');
const cors = require('cors');
const app = express();
const PORT = 3000;
app.use(cors());
app.use(bodyParser.json());
app.post('/register', (req, res) => {
  const { firstName, lastName, email, userId, password } = req.body;
  if (!firstName || !lastName || !email || !userId || !password) {
    return res.status(400).json({ message: 'All fields are required.' });
  }
  const sql = `INSERT INTO Users (firstName, lastName, email, userId, password)
               VALUES (?, ?, ?, ?, ?)`;
  db.query(sql, [firstName, lastName, email, userId, password], (err, result) => {
    if (err) {
      console.error('Error inserting user:', err);
      return res.status(500).json({ message: 'Database error or user already exists.' });
    }
    res.status(201).json({ message: 'User registered successfully!' });
  });
});
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
