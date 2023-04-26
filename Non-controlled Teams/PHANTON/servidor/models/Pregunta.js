
const mongoose = require('mongoose');

const PreguntaSchema = mongoose.Schema({
    nombre: {
        type: String,
        required: true
    },
    categoria: {
        type: String,
        required: true
    },
    pregunta: {
        type: String,
        required: true
    },
    fechaCreacion: {
        type: Date,
        default: Date.now()
    }
});

module.exports = mongoose.model('Pregunta', PreguntaSchema);