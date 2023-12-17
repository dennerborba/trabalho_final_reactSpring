import { useEffect, useState } from "react"
import RestauranteCard from "./restauranteCard"

export default function Consulta() {
    const [restaurantes, setRestaurantes] = useState([])
    function consultarRestaurantes() {
        fetch('http://localhost:8080/restaurantes')
            .then(data => data.json())
            .then(response => setRestaurantes(response))
    }
    useEffect(consultarRestaurantes, [])
    return (
        <div>
            <div className="d-block">
            {
                restaurantes.map(rst => <RestauranteCard restaurante ={rst}/>)
            }
            </div>
        </div>
    )
}