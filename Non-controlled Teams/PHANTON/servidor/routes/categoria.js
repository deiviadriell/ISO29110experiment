const express = require('express');
const router = express.Router();
const categoriaController = require('../controllers/categoriaController');

router.post('/',categoriaController.crearCategoria);
router.get('/',categoriaController.obtenerCategorias);
router.put('/:id',categoriaController.actualizarCategorias);
module.exports = router;