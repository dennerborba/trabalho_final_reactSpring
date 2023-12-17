import { Link } from "react-router-dom";

export default function RestauranteCard(props){
    return (
        <div className="jumbotron mt-3">
            <div className="ms-4">
                <Link to={`/restaurantes/${props.restaurante.idRestaurante}`}><h1>{props.restaurante.nome}</h1></Link>
                <h2>{props.restaurante.descricao}</h2>
                <p>Telefone: {props.restaurante.telefone}</p>
                <p>Endereço: {props.restaurante.endereco}</p>

            </div>
        </div>
    )
}