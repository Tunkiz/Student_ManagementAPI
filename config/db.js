const db_config = require("../config/db_config");
const mysql = require("mysql");

const connection = mysql.createConnection(
    {
        host: db_config.HOST,
        user: db_config.USER,
        password: db_config.PASSWORD,
        database: db_config.DB
    }
);

connection.connect(error =>{
    if(error) throw error;
    console.log("Connected successfully");
})

module.exports = connection;