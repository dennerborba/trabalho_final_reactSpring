import { useEffect, useState } from "react"
import AvaliacaoCard from "./avaliacaoCard"
import { useParams } from "react-router-dom"

export default function MostrarAvaliacoes() {
    const { idRestaurante } = useParams()
    const [avaliacao, setAvaliacao] = useState([])

    function consultarAvaliacoes() {
        fetch(`http://localhost:8080/restaurantes/${idRestaurante}/avaliacoes`)
            .then(data => data.json())
            .then(response => setAvaliacao(response))
    }
    useEffect(consultarAvaliacoes, [])
    return (
        <div>
            <div className="d-block">
            {
                avaliacao.map(ava => <AvaliacaoCard avaliacao ={ava}/>)
            }
            </div>
        </div>
    )
}