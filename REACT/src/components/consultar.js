import { useEffect, useState } from "react"
import Restaurantes from "./restaurantes"

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
            {
                restaurantes.map(rst => <Restaurantes restaurante ={rst}/>)
            }
        </div>
    )
}