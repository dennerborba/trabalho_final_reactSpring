import { useEffect, useState } from "react"
import AvaliacaoCard from "./avaliacaoCard"
import { useParams } from "react-router-dom"
import Consulta from "./consultar"

export default function ConsultarAvaliacoes() {
    const { idRestaurante, } = useParams()
    const [avaliacoes, setAvaliacoes] = useState([])

    function consultarAvaliacoes() {
        fetch(`http://localhost:8080/restaurantes/${idRestaurante}/avaliacoes`)
            .then(data => data.json())
            .then(response => setAvaliacoes(response))
    }

    useEffect(() => {
        consultarAvaliacoes()
    }, [])

    return (
        <div>
            {
                avaliacoes.map(ava => <AvaliacaoCard avaliacao={ava} />)
            }
        </div>
    )
}
