import { useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function Avaliacao() {
    const [comentario, setComentario] = useState('')
    const [classificacao, setClassificacao] = useState('')
    const { idRestaurante } = useParams()

    function salvarComentario(){
        let obj = {comentario: comentario, classificacao: classificacao}
        fetch(`http://localhost:8080/restaurantes/${idRestaurante}/avaliacoes` ,
        {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(obj)
        })
        .then(x => alert('Obrigado pela sua avaliação!'))
    }

    return (
        <div className="container-fluid mt-4">
            <div className="row align-items-center">
                <div className="col-md-10 mx-auto col-lg-5">
                    <form className="p-4 p-md-8 border rounded-3 bg-dark text-white">
                        <div className="form-row mb-3">
                            <label className="form-label">Insira um comentário sobre este restaurante:</label>
                            <br/>
                            <textarea className="form-control" value={comentario} onChange={txt => setComentario(txt.target.value)}></textarea>
                        </div>
                        <label className="form-label">Selecione uma classificação para este restaurante</label>
                        <select className="form-control" value={classificacao} onChange={txt => setClassificacao(Number(txt.target.value))}>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                        <div className="mt-3 d-flex justify-content-around">
                            <button onClick={salvarComentario} className="btn btn-outline-success">Salvar</button>
                            <Link to={'/restaurantes'}><button className="btn btn-outline-danger">Voltar</button></Link>
                        </div>
                    </form>
                </div>
            </div >
        </div >
    )
}