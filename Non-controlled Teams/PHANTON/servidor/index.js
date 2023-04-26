const express = require('express');
const conectarDB = require('./config/db');
const cors = require("cors");
//creamos el servidor

const app = express();

// base de datos

conectarDB();
app.use(cors());
app.use(express.json());
app.use('/api/categorias',require('./routes/categoria'));
app.use('/api/preguntas', require('./routes/pregunta'));
app.use("/api/registros", require("./routes/registro"));



app.listen(4000,()=>{
    console.log("El servidor está correindo perfectamente")
})