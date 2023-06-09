const mongoose = require('mongoose');

const CategoriaSchema = mongoose.Schema({
    nombrecategoria:{
        type: String,
        required: true
    },
    descripcioncategoria:{
        type: String,
        required: true
    },
    fechaCreacion: {
        type: Date,
        default: Date.now()
    }
});

module.exports = mongoose.model('Categoria',CategoriaSchema);