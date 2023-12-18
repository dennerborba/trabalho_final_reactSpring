import { Link } from "react-router-dom";

export default function RestauranteCard({ restaurante }){
    return (
        <div className="jumbotron mt-3">
            <div className="ms-4">
                <Link to={`/restaurantes/${restaurante.idRestaurante}`}><h1>{restaurante.nome}</h1></Link>
                <h2>{restaurante.descricao}</h2>
                <p>Telefone: {restaurante.telefone}</p>
                <p>Endereço: {restaurante.endereco}</p>
            </div>
        </div>
        
    )
}