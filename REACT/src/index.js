import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Restaurantes from './components/restaurantes';
import EditarAvaliacao from './components/editarAvaliacao';
import ConsultarAvaliacoes from './components/avaliacaoConsulta';
import Consulta from './components/consultar';


const rotas = createBrowserRouter([
  {
   path:"/",
   element: <App />,
   children: [
    {path: '/restaurantes', element: <Consulta/>},
    {path: '/restaurantes/:idRestaurante', element: <Restaurantes />},
    {path: '/avaliacoes/editar/:idAvaliacao', element: <EditarAvaliacao />}
   ]
  }
])


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
   <RouterProvider router={rotas} />
  </React.StrictMode>
);

