import React, { useState, useEffect } from 'react'
import { createEmployee, getEmployee,updateEmployee } from '../services/employeeService'
import { useNavigate, useParams } from 'react-router-dom'

const EmployeeComponent = () => {

  const [firstName, setFirstName] = useState('')
  const [lastName, setLastName] = useState('')
  const [email, setEmail] = useState('')

  const { id } = useParams();
  const [errors, setErrors] = useState({
    firstName: '',
    lastName: '',
    email: ''
  })


  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      getEmployee(id).then((response) => {
        // console.log(response);
        setFirstName(response.data.firstName);
        setLastName(response.data.lastName);
        setEmail(response.data.email);
      }).catch(error => {
        console.error(error);
      })
    }

  }, [id])

  /*
    function handleFirstName(event) {
      console.log(event);
      setFirstName(event.target.value);
    }
  
    const handleFirstName = (event) => setFirstName(event.target.value);
  
  
    function handleLastName(event) {
      setLastName(event.target.value);
    }
  
    function handleEmail(event) {
      setEmail(event.target.value);
    }
    */

  function saveOrUpdateEmployee(e) {
    e.preventDefault(); //? By default on hitting the submit button, the data is sent to the server and page get reloaded. In order to prevent this, we use preventDefault allowing us for custom handling.

    if (validateForm()) {

      const employee = { firstName, lastName, email };
      console.log(employee)

      if (id) {
        updateEmployee(id, employee).then((response) => {
          console.log(response.data);
          navigate('/employees');
        }).catch(error => {
          console.error(error);
        })
      }
      else {
        createEmployee(employee).then((response) => {
          console.log(response.data);
          navigate('/employees');
        }).catch(error =>{
          console.error(error);
        })
      }

    }

  }

  function validateForm() {
    let valid = true;

    const errorCopy = { ...errors }
    // console.log("with trim " +firstName.trim());
    // console.log("Without trim "+firstName);
    if (firstName.trim()) {
      errorCopy.firstName = '';
    } else {
      errorCopy.firstName = 'First Name is Required';
      valid = false;
    }

    if (lastName.trim()) {
      errorCopy.lastName = '';
    } else {
      errorCopy.lastName = 'Last Name is Required';
      valid = false;
    }

    if (email.trim()) {
      errorCopy.email = '';
    } else {
      errorCopy.email = 'Email is Required';
      valid = false;
    }

    setErrors(errorCopy);
    return valid;
  }

  function pageTitle() {
    if (id) {
      return <h2 className='text-center'>Update Employee</h2>
    }
    else {
      return <h2 className='text-center'>Add Employee</h2>
    }
  }
  return (
    <div className='container mt-5'>
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3 shadow-sm p-3 mb-5 bg-body rounded bg-primary'>
          {
            pageTitle()
          }
          <div className='card-body'>
            <form>
              <div className='mb-2'>
                <label className='form-label'>First Name</label>
                <input
                  type="text"
                  placeholder='Enter Employee First Name'
                  name='firstName'
                  value={firstName}
                  className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}
                  // onChange={handleFirstName} 
                  onChange={(event) => setFirstName(event.target.value)} />

                {errors.firstName && <div className='invalid-feedback'>{errors.firstName}</div>}
              </div>

              <div className='mb-2'>
                <label className='form-label'>Last Name</label>
                <input
                  type="text"
                  placeholder='Enter Employee last Name'
                  name='lastName'
                  value={lastName}
                  className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}
                  onChange={(event) => setLastName(event.target.value)} />

                {errors.lastName && <div className='invalid-feedback'>{errors.lastName}</div>}
                {/* { (errors.lastName) ? <div className='invalid-feedback'>{errors.lastName}</div> : ''} alternative syntax of above method */}
              </div>

              <div className='mb-2'>
                <label className='form-label'>Email</label>
                <input
                  type="text"
                  placeholder='Enter Employee Email Address'
                  name='email'
                  value={email}
                  className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                  onChange={(event) => setEmail(event.target.value)} />

                {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
              </div>

              <button className='btn btn-info' onClick={saveOrUpdateEmployee}>Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default EmployeeComponent