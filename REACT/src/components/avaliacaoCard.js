import { Link } from "react-router-dom"

export default function AvaliacaoCard(props){
    
    function excluirAvaliacao(){
        fetch(`http://localhost:8080/restaurantes/${props.restaurante.idRestaurante}/avaliacoes/${props.avaliacao.id_avaliacao}` ,
        {
            method: 'DELETE'
        })
        .then(x => alert('O comentário foi excluído.'))
    }

    return (
        <div className="card">
            <div>
             <span className="fw-bold me-1">Comentário sobre o restaurante</span>   
             <span className="text-dark">{props.avaliacao.comentario}</span>
            </div>
            <div>
                <span className="fw-bold me-1">Classificação do restaurante</span>
                <span className="text-dark">{props.avaliacao.classificacao}</span>
            </div>
            <div className="mt-2 d-flex justify-content-between">
                <Link to={`/avaliacoes/editar/${props.avaliacao.id_avaliacao}`}><button className="btn btn-outline-primary">Editar Avaliação</button></Link>
                <button onClick={excluirAvaliacao} className="btn btn-outline-danger">Excluir</button>
            </div>
        </div>
    )
}