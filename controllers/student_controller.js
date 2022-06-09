const Student = require('../models/student_model');

exports.create = (req, res)=>{
    if(!req.body){
        res.status(400).send({
            message : "Content cannot be empty"
        });
    }
    const student = new Student({
        stu_name: req.body.stu_name,
        stu_contact_no: req.body.stu_contact_no,
        stu_email: req.body.stu_email,
        stu_address: req.body.stu_address,
        course_id: req.body.course_id,
        dept_id: req.body.dept_id
    })

    Student.create(student, (err, data)=>{
        if(err)
            res.status(500).send({
                message: err.message || "Some errors ocurred while creating a new student"
            });
        else res.send(data)
    })
}

exports.getAll = (req, res)=>{
    const stu_name = req.query.stu_name;
   Student.getAll(stu_name, (err, data)=>{
     if(err)
        res.status(400).send({
            message: "Some erros ocurred while retrieving students"
        });
        res.send(data);  
   });
}
exports.getOne = (req,res) =>{
    const stu_id = req.params.stu_id;
    Student.getById(stu_id, (err, data)=>{
        if(err)
            if(err.kind == "Not_Found")
                res.status(404).send({
                    message: `Student with Id ${stu_id} not found`
                });
            else
                res.status(500).send({
                    message: err.message || "Some errors occurred while retrieving a student"
                })
        res.send(data);
    });
}
exports.update = (req, res) =>{
    if(!req.body)
        res.status(400).send({
            message: "Content cannot be empty"
        });
    
    const stu_id = req.params.stu_id;
    Student.updateById(stu_id, new Student(req.body), (err, data)=>{
        if(err)
            if(err.kind == "Not_Found")
                res.status(404).send({
                    message: `Student with id ${stu_id} not found`
                });
            else
                res.status(500).send({
                    message: err.message || `Some errors occured while updating a student`
                });
        res.send(data);       
    });
}

exports.delete = (req, res)=>{
    const stu_id = req.params.stu_id;
    Student.delete(stu_id, (err, data)=>{
        if(err)
            if(err.kind == "Not_Found")
                res.status(404).send({
                    message: `Student with id ${stu_id}`
                });
            else
                res.status(500).send({
                    message:`Some errors ocurred while deleting a student with id ${stu_id}`
                });
        res.send({message: "Student deleted"});
    });
}