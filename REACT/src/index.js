import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Restaurantes from './components/restaurantes';
import Consulta from './components/consultar';


const rotas = createBrowserRouter([
  {
   path:"/",
   element: <Consulta />,
   children: [
    {path: '/restaurantes', element: <Restaurantes />}
   ]
  }
])


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
   <RouterProvider router={rotas} />
  </React.StrictMode>
);

