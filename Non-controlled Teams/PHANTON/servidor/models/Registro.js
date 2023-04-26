const mongoose = require("mongoose");

const RegistroSchema = mongoose.Schema({
  nombre: {
    type: String,
    required: true,
  },
  apellido: {
    type: String,
    required: true,
  },
  correo: {
    type: String,
    required: true,
  },
  contrasena: {
    type: String,
    required: true,
  },
  fechaCreacion: {
    type: Date,
    default: Date.now(),
  },
});

module.exports = mongoose.model("Registro", RegistroSchema);
