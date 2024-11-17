import React, { useEffect, useState } from 'react'
import { deleteEmployee, listEmployees } from '../services/employeeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {

    /*
    const dummyData = [
        {
            "id" : 1,
            "firstName" : "John",
            "lastName" : "Cena",
            "email" : "john@gmail.com"
        },
        {
            "id" : 2,
            "firstName" : "Randy",
            "lastName" : "Ortan",
            "email" : "randy@gmail.com"
        },
        {
            "id" : 3,
            "firstName" : "Roman",
            "lastName" : "Reings",
            "email" : "roman@gmail.com"
        }
    ]
        */

    const [employees, setEmployees] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        getAllEmployees();
    }, [])

    function getAllEmployees() {
        listEmployees().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function addNewEmployee() {
        navigator('/add-employee');
    }

    function updateEmployee(id) {
        navigator(`/edit-employee/${id}`)
        // navigator('/edit-employee/' + id); alternative method...
    }

    function removeEmployee(id) {
        deleteEmployee(id).then((response) => {
            console.log(response.data);
            getAllEmployees();
        }).catch(error => {
            console.error(error);
        })
    }

    /*
    Alternative Technique to print the  employees list.
    const rows = [];
    employees.forEach(employees =>{
        rows.push(
            <tr key={employees.id}>
                <td>{employees.id}</td>
                <td>{employees.firstName}</td>
                <td>{employees.lastName}</td>
                <td>{employees.email}</td>
                <td>
                    <button className='btn btn-primary' onClick={() => updateEmployee(employees.id)}>Update</button>
                    <button className='btn btn-danger' onClick={() => removeEmployee(employees.id)}
                        style={{ marginLeft: '10px' }}
                    >Delete</button>
                </td>
            </tr>
        )
    })

    */

    return (
        <div className='container'>

            <h2 className='text-center'>List Of Employees</h2>
            <button className='btn btn-success mb-2' onClick={addNewEmployee}>Add Employee</button>
            <table className='table table-striped table-light table-bordered'>
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Employee First Name</th>
                        <th>Employee Last Name</th>
                        <th>Employee Email Id</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        // rows
                        employees.map(employee =>{
                            return <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td>
                                <button className='btn btn-primary' onClick={() => updateEmployee(employee.id)}>Update</button>
                                <button className='btn btn-danger' onClick={() => removeEmployee(employee.id)}
                                    style={{marginLeft: '10px'}}
                                    >Delete</button>
                            </td>
                        </tr>

                        })
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListEmployeeComponent

