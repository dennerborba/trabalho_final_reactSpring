import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import Avaliacao from "./avaliacao"
import ConsultarAvaliacoes from "./avaliacaoConsulta"
//página que lista restaurantes e avaliações
export default function Restaurantes() {
    const { idRestaurante } = useParams()
    const [restaurante, setRestaurante] = useState('')
    useEffect(() => {
        fetch(`http://localhost:8080/restaurantes/${idRestaurante}`)
            .then(response => response.json())
            .then(data => setRestaurante(data))

    }, [idRestaurante])

    return (
        <div className="container">
            <div className="form-group">
                <h1 className="text-center text-danger">{restaurante.nome}</h1>
                <h2 className="text-center">{restaurante.descricao}</h2>
                <h3 className="text-center">{restaurante.endereco}</h3>
                <h3 className="text-center">{restaurante.telefone}</h3>
            </div>
            <div>
                <Avaliacao />
            </div>
            <div className="mt-4  ">
                <ConsultarAvaliacoes />
            </div>
        </div>
    )

}
