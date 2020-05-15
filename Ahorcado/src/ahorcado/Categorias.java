package ahorcado;

import java.util.Random;

public class Categorias {

    String[] colores = {"color", "blanco", "negro", "gris", "rojo", "naranja", "anaranjado", "amarillo",
        "verde", "celeste", "azul", "violeta", "rosa", "rosado", "marron", "cafe"
    };
    String[] animales={"perro","gato","caballo","morsa","nutria","oveja","mono","raton","conejo","jirafa",
        "gallina","tigre","conejo","cerdo","pulpo","cuervo"
    };
    String[] tiempo={"dia","hora","minuto","segundo","mes","epoca","era","fecha","instante","calendario","edad",
            "momento","semana","decada","siglo","milenio"
    };
    String[] biomas={"campo","bosque","selva","desierto","plya","rio","lago","laguna","monte","oceano",
        "mar","cerro","meseta","llanura","costa","montaña"
    };
    String[] frutas={"ciruela","manzana","naranja","palta","durazno","sandia","tomate","pera","mango","platano",
        "limon","papaya","guayaba","mandarina","fresa","cereza"        
    };
    
    public String SeleccionarPalabra(String Categoria){
        
        String Palabra="";
        
        switch(Categoria){
            case "Todas":
                Palabra = TodasLasCategorías();
                break;
            case "Aleatorio":
                Palabra= CategoriaRandom();
                break;
        }
        
        return Palabra;
    }
    
    public String TodasLasCategorías(){
        
        String[] SuperCategoria = new String[colores.length+animales.length+tiempo.length+biomas.length+frutas.length];
        String superior="";
        
        for(int i=0; i<colores.length; i++){
            SuperCategoria[i] = colores[i].toString();
        }
        
        for(int i=0; i<animales.length; i++){
            SuperCategoria[colores.length+i] = animales[i].toString();
        }
        
        for(int i=0; i<tiempo.length; i++){
            SuperCategoria[animales.length+colores.length+i] = tiempo[i].toString();
        }
        
        for(int i=0; i<biomas.length; i++){
            SuperCategoria[tiempo.length+animales.length+colores.length+i] = biomas[i].toString();
        }
        
        for(int i=0; i<frutas.length; i++){
            SuperCategoria[biomas.length+tiempo.length+animales.length+colores.length+i] = frutas[i].toString();
        }
                
        
        String palabra = GenerarPalabraRandom(SuperCategoria);
        
        return palabra;
    }
    
    
    
    public String CategoriaRandom(){
        
        Random r = new Random();
        int x = r.nextInt((4 - 0) + 1) + 0;
        
        String Palabra="";
        
        switch(x){
            case 0:
                Palabra =GenerarPalabraRandom(colores);
                break;
            case 1:
                Palabra =GenerarPalabraRandom(animales);
                break;
            case 2:
                Palabra =GenerarPalabraRandom(tiempo);
                break;
            case 3:
                Palabra =GenerarPalabraRandom(biomas);
                break;
            case 4: 
                Palabra =GenerarPalabraRandom(frutas);
                break;
        }
        
        System.out.println("Palabra: "+Palabra);
        
        return Palabra;
    }
    
    public String GenerarPalabraRandom(String[] categoria){
        
        Random r = new Random();
        int x = r.nextInt((categoria.length - 0) + 1) + 0;
        
        return categoria[x];
    }

}
