const sql = require('../config/db');

//student constractor
const Student =  function(student){
    this.stu_name = student.stu_name;
    this.stu_contact_no = student.stu_contact_no;
    this.stu_email = student.stu_email;
    this.stu_address = student.stu_address;
    this.course_id = student.course_id;
    this.dept_id = student.dept_id;
}
//Creating a new student
Student.create = (newStudent, result)=>{
    sql.query("INSERT INTO students SET?", newStudent, (err, res)=>{
        if(err){
            console.log("Error ", err);
            result(null, err);
            return;
        }
        console.log("Student successfully inserted", {student_id: res.insertId, ...newStudent});
        result(null, {stu_id: res.insertId, ...newStudent});
    })
}
//Displaying all available students
Student.getAll = (stu_name, result) =>{
    var query = "SELECT * FROM students";
    if(stu_name){
        query += `WHERE stu_name LIKE ${stu_name}`;
    }
    sql.query(query, (err, res)=>{
        if(err){
            console.log("Error ", err);
            result(null, err);
            return;
        }
        result(null, res);
    });
}

//Getting a student by stu_id
Student.getById = (stu_id, result)=>{
    sql.query(`SELECT * FROM students WHERE stu_id =${stu_id}`, (err, res)=>{
        if(err){
            console.log("Error", err);
            result(null, err);
            return
        }
        result(null, res);
    });
}

//Updating a student by stu_id
Student.updateById = (stu_id,student, result)=>{
    sql.query(`UPDATE students SET stu_name =?, stu_contact_no =?, stu_email =?, stu_address = ?, course_id =?, dept_id =? 
    WHERE stu_id = ${stu_id}`,
    [student.stu_name, student.stu_contact_no, student.stu_email, student.stu_address, student.course_id, student.dept_id, stu_id],
     (err, res)=>{
        if(err){
            console.log("Error ", err);
            result(null, err);
            return;
        }
        if(res.affectedRows == 0){
            result({kind:"Not_Found"}, null)
            return;
        }
        console.log("Student updated", {student_Id: stu_id, ...student});
        result(null, {stu_id: stu_id, ...student});
    });
}

//removing a student from database
Student.delete = (stu_id, result)=>{
    sql.query(`DELETE FROM students WHERE stu_id = ?`, stu_id, (err, res)=>{
        if(err){
            console.log("Error ", err);
            result(null, err)
            return;
        }
        if(res.affectedRows == 0){
            result({kind:"Not_Found"});
        }
        console.log(`Student with student Id ${stu_id} removed from database`)
        result(null, res);
    })
}

module.exports = Student;