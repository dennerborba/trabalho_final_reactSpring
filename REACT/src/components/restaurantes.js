export default function Restaurantes(props) {
 
    return (
        <div className="container">
            <div className="row p-3">
                <span className={props.restaurante.nome}></span>
            </div>
            <div className="row p-3">
                <span className={props.restaurante.telefone}></span>
            </div>
            <div className="row p-3">
                <span className={props.restaurante.endereco}></span>
            </div>
            <div className="row p-3">
                <span className={props.restaurante.descricao}></span>
            </div>
        </div>
    )
}
