const mysql = require('mysql2');

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',         
  password: 'root@123',       
  database: 'userDB'
});
connection.connect((err) => {
  if (err) {
    console.error('Error connecting to MySQL DB:', err);
    return;
  }
  console.log('Connected to MySQL Database!');
});
module.exports = connection;
