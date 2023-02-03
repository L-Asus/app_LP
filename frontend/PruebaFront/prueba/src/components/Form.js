import Reacto, {useEffect, useState} from 'react';

const Form = ({persona, setPersona}) => {
    const handleChange = e => {
        setPersona({
            ...persona,
            [e.target.name]: e.target.value
        })
    }

    let{mail, mailPass, phone, countryPhone, active} = persona

    const handleSubmit = () => {
        const requestInit = {
            methos: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(persona)
        }
        fetch('http://localhost:8080/persona/', requestInit)
        .then(res => res.json())
        .then(res => setPersona(res))

        setPersona({
            email: '',
            mailPass: '',
            phone: '',
            countryPhone: '',
            active: false
        })
    }
    

    return (
        <form onSubmit={handleSubmit}>
            <div className="mb-3">
                <label htmlFor='email' className='form-label'>Email</label>
                <input name='email' onChange={handleChange} type='text' id='email' className='form-control'/>
            </div>
            <div className="mb-3">
                <label htmlFor='mailPass' className='form-label'>Password</label>
                <input name='mailPass' onChange={handleChange} type='text' id='mailPass' className='form-control'/>
            </div>
            <div className="mb-3">
                <label htmlFor='phone' className='form-label'>Phone</label>
                <input name='phone' onChange={handleChange} type='text' id='phone' className='form-control'/>
            </div>
            <div className="mb-3">
                <label htmlFor='countryPhone' className='form-label'>Country Phone</label>
                <input name='countryPhone' onChange={handleChange} type='text' id='countryPhone' className='form-control'/>
            </div>
            <div className="mb-3">
                <label htmlFor='active' className='form-label'>Active</label>
                <input name='active' onChange={handleChange} type='text' id='active' className='form-control'/>
            </div>
            <button type="submit" className="btn btn-dark">Enviar</button>
        </form>
    )
}

export default Form;