module.exports = app =>{
    const router = require('express').Router();
    const student = require('../controllers/student_controller');

    router.post('/add', student.create);
    router.get('/getAll', student.getAll);
    router.get('/:stu_id', student.getOne);
    router.put('/upStudent/:stu_id', student.update);
    router.delete('/delStudent/:stu_id', student.delete);

    app.use('/students', router);
}