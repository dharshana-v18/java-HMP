// script.js

document.addEventListener('DOMContentLoaded', () => {
    const addPatientForm = document.getElementById('addPatientForm');
    const addDoctorForm = document.getElementById('addDoctorForm');
    const appointmentForm = document.getElementById('appointmentForm');

    const patientSuccess = document.getElementById('patientSuccess');
    const doctorSuccess = document.getElementById('doctorSuccess');
    const appointmentSuccess = document.getElementById('appointmentSuccess');

    addPatientForm.addEventListener('submit', (e) => {
        e.preventDefault();
        // Here, you would normally send the data to the server to add a patient
        patientSuccess.innerText = "Patient added successfully!";
        patientSuccess.style.display = 'block';

        // Hide the message after 3 seconds
        setTimeout(() => {
            patientSuccess.style.display = 'none';
        }, 3000);
    });

    addDoctorForm.addEventListener('submit', (e) => {
        e.preventDefault();
        // Normally, send data to the server to add a doctor
        doctorSuccess.innerText = "Doctor added successfully!";
        doctorSuccess.style.display = 'block';

        // Hide the message after 3 seconds
        setTimeout(() => {
            doctorSuccess.style.display = 'none';
        }, 3000);
    });

    appointmentForm.addEventListener('submit', (e) => {
        e.preventDefault();
        // Normally, send data to the server to book an appointment
        appointmentSuccess.innerText = "Appointment booked successfully!";
        appointmentSuccess.style.display = 'block';

        // Hide the message after 3 seconds
        setTimeout(() => {
            appointmentSuccess.style.display = 'none';
        }, 3000);
    });
});
