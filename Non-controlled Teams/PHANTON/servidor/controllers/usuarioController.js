expoert.obtenerUsuario= async(req, res) =>{
    try{
        const usuario = await usuario.find();
        res.json(usuario)
    }catch(error){
        console.log(error);
        res.status(500).send('Hubo un error');
    }
}