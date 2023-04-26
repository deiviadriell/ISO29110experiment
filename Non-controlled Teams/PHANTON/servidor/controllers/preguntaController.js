const Pregunta = require("../models/Pregunta");


exports.crearPregunta = async (req, res) => {

    try {
        let pregunta;

        // Creamos nuestra pregunta
        pregunta = new Pregunta(req.body);

        await pregunta.save();
        res.send(pregunta);
        
    } catch (error) {
        console.log(error);
        res.status(500).send('Hubo un error');
    }
}

