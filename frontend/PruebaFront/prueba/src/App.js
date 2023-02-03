import { Fragment, useState, useEffect } from 'react';
import Navbar from './components/Navbar';
import PersonasList from './components/PersonasList';
import Form from './components/Form'

function App() {
  const [persona, setPersona] = useState({
    email: '',
    mailPass: '',
    phone: '',
    countryPhone: '',
    active: false
  })

  const [personas, setPersonas] = useState([])

  useEffect(() => {
    const getPersonas = () => {
      fetch('http://localhost:8080/persona', {
        method: "GET",
        headers: { "Content-type": "application/json" }
      })
        .then(res => res.json())
        .then(res => setPersonas(res))
    }
    getPersonas()
  }, [])


  return (
    <Fragment>
      <Navbar brand="CRUD" />
      <div className="container">
        <div className="col-4">
          <h2 style={{ textAlign: 'center' }}>Formulario de personas</h2>
          <Form persona={persona} setPersona={setPersona} />
        </div>
        <div className="col-5">
          <h2 style={{ textAlign: 'center' }}>Lista de personas</h2>
          <PersonasList personas={personas} />
        </div>
      </div>
    </Fragment>
  );
}

export default App;
