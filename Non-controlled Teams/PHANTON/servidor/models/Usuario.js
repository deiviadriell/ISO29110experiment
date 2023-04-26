const mongoose = require('mongoose');

const UsuarioSchema = mongoose.Schema({
    correo: {
        type: String,
        required: true
    },
    rol: {
        type :String,
        required: true
    },
    password: {
        typer :String,
        required: true
    }

});
module.exports = mongoose.model('Usuario', UsuarioSchaema);