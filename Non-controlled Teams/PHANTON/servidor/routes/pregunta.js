// Rutas para producto
const express = require('express');
const router = express.Router();
const preguntaController = require('../controllers/preguntaController');

// api/productos
router.post('/', preguntaController.crearPregunta);
module.exports = router;