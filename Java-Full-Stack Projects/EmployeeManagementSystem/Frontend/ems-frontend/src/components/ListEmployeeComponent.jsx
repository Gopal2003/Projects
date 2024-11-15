import React,{useEffect, useState} from 'react'
import { listEmployees } from '../services/employeeService'
import {useNavigate} from 'react-router-dom'

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

    useEffect(() =>{
        listEmployees().then((response) =>{
            setEmployees(response.data);
        }).catch(error =>{
            console.error(error);
        })
    }, [])

    function addNewEmployee(){
        navigator('/add-employee');
    }

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
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee =>{
                        return <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.email}</td>
                    </tr>
                        
                    })
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent

