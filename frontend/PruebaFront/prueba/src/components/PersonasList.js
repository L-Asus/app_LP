import React from 'react';

const PersonasList = ({ personas }) => {
    return (
        <table className="table" id="tblPersonas">
            <thead>
                <tr>
                    <th>id</th>
                    <th>email</th>
                    <th>mailPass</th>
                    <th>phone</th>
                    <th>countryPhone</th>
                    <th>tag</th>
                    <th>createdAt</th>
                    <th>active</th>
                </tr>
            </thead>
            <tbody>
                {personas.map(persona => (
                    <tr key={persona.id}>
                        <td>{persona.id}</td>
                        <td>{persona.email}</td>
                        <td>{persona.mailPass}</td>
                        <td>{persona.phone}</td>
                        <td>{persona.countryPhone}</td>
                        <td>{persona.tag}</td>
                        <td>{Date.parse(persona.createdAt)}</td>
                        <td>{persona.active}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    )
}

export default PersonasList;