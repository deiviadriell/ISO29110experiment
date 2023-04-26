const Categoria = require("../models/Categoria");

exports.crearCategoria = async (req,res) =>{
    try{
        let categoria;
        categoria = new Categoria(req.body);
        await categoria.save();
        res.send(categoria);

    }catch(error){
        console.log(error);
        res.status(500).send('Hubo un error');

    }
}

exports.obtenerCategorias = async(req,res) =>{
    try{
        const categorias = await Categoria.find();
        res.json(categorias);
    }catch(error){
        console.log(error);
        res.status(500).send('Hubo un error');
    }
}
exports.actualizarCategorias = async (req,res) =>{
    try{
        const{nombrecategoria,descripcioncategoria} = req.body;
        let categoria = await Categoria.findById(req.params.id);
        if(!categoria){
            res.status(404).json({msg:"No existe la categoria"})
        }

        categoria.nombrecategoria = nombrecategoria;
        categoria.descripcioncategoria = descripcioncategoria;
        
        categoria = await Categoria.findOneAndUpdate({_id: req.params.id},categoria,{new:true})
        res.json(categoria);

    }catch(error){
        console.log(error);
        res.status(500).send('Hubo un error');
    }
}