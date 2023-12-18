import { Link, Outlet } from 'react-router-dom'


function App() {
  return (
    <div className="App">
    <nav className='navbar navbar-expand-lg navbar-dark bg-dark border-bottom shadow-sm mb-3 '>
    <Link to={'/restaurantes'}><button className='btn btn-link text-danger fs-2'>AvaliAQUI!</button></Link>
    </nav>
    <main>
      <Outlet />
    </main>
    </div>
  );
}

export default App;
