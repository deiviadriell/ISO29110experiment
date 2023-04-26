const Registro = require("../models/Registro");

exports.registrarUsuario = async (req, res) => {
  try {
    let registro;

    //Creamos nuestro registro
    registro = new Registro(req.body);
    await registro.save();
    res.send(registro);
  } catch (error) {
    console.log(error);
    res.status(500).send("Hubo un error");
  }
};
