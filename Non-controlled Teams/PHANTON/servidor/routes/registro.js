//Rutas para registros

const express = require("express");
const router = express.Router();
const registroController = require("../controllers/registroController");

// api/registros

router.post("/", registroController.registrarUsuario);

module.exports = router;
