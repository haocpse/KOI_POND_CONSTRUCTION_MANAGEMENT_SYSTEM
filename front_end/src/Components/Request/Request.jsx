import React, { useEffect, useState } from "react";
import axios from "axios";
import { toast, ToastContainer } from "react-toastify";

const Request = () => {
    const [requests, setRequests] = useState([]);
    const [consultantList, setConsultantList] = useState([]);
    const [designerList, setDesignerList] = useState([]);
    const [constructorList, setConstructorList] = useState([]);
    const [selectedConsultantId, setSelectedConsultantId] = useState(null);
    const [selectedDesignerId, setSelectedDesignerId] = useState(null);
    const [selectedConstructorId, setSelectedConstructorId] = useState(null);

    const handleStatusChange = async (statusTab) => {
        try {
            const respone = await axios.get(`http://localhost:8080/construct-orders?status=${statusTab}`, {
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`,
                }
            });
            setRequests(respone.data.data)
        } catch (error) {
            console.error('Error fetching Status:', error);
            toast.error('Failed to load Status. ^^');
        }

    }

    useEffect(() => {
        handleStatusChange("all")
    }, []);

    const formatDate = (dateString) => {
        if (!dateString) return "";
        const date = new Date(dateString);
        const day = String(date.getDate()).padStart(2, "0");
        const month = String(date.getMonth() + 1).padStart(2, "0");
        const year = date.getFullYear();
        return `${day}/${month}/${year}`;
    };

    const getStatusIcon = (status) => {
        switch (status) {
            case "CONSULTING":
                return { icon: <i className="fas fa-comments" title="Consulting" style={{ marginRight: '5px' }}></i>, className: "text-primary" };
            case "DESIGNING":
                return { icon: <i className="fa-solid fa-pen" title="Designing" style={{ marginRight: '5px' }}></i>, className: "text-success" };
            case "CONSTRUCTING":
                return { icon: <i className="fa-solid fa-wrench" title="Constructing" style={{ marginRight: '5px' }}></i>, className: "text-warning" };
            case "REQUESTED":
            default:
                return { icon: <i className="fas fa-info-circle" title="Requested" style={{ marginRight: '5px' }}></i>, className: "text-secondary" };
        }
    };


    return (
        <div className="container-fuild mt-4">
            <ToastContainer position="top-right" autoClose={5000} hideProgressBar={false} closeOnClick pauseOnFocusLoss draggable pauseOnHover />
            <h2 className="text-center">Manage Requests</h2>
            <div>
                <nav className="nav justify-content-center mb-2">
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("all")}>All</button>
                    </div>
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("requested")}>Requested</button>
                    </div>
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("consulting")}>Consulting</button>
                    </div>
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("confirm_quotaion")}>Confirm Quotation</button>
                    </div>
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("paid_1")}>Paid 1</button>
                    </div>
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("designing")}>Designing</button>
                    </div>
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("confirm_design")}>Confirm Design</button>
                    </div>
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("paid_2")}>Paid 2</button>
                    </div>
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("constructing")}>Constructing</button>
                    </div>
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("constructed")}>Constructed</button>
                    </div>
                    <div className="nav-item">
                        <button className="btn btn-outline-primary mx-1" onClick={() => handleStatusChange("paid_3")}>Finished</button>
                    </div>
                </nav>
            </div>
            <table className="table table-bordered ">
                <thead>
                    <tr>
                        <th scope="col" className="text-center">Customer</th>
                        <th scope="col" className="text-center">Phone</th>
                        <th scope="col" className="text-center">Address</th>
                        <th scope="col" className="text-center">Start Date</th>
                        <th scope="col" className="text-center">End Date</th>
                        <th scope="col" className="text-center">Type</th>
                        <th scope="col" className="text-center">Total Price</th>
                        <th scope="col" className="text-center">Consultant</th>
                        <th scope="col" className="text-center">Designer</th>
                        <th scope="col" className="text-center">Constructor</th>
                        <th scope="col" className="text-center">Status</th>
                    </tr>
                </thead>
                <tbody>
                    {requests.length === 0 ? (
                        <tr>
                            <td colSpan="10" className="text-center">
                                Your system has no Request ^^ !
                            </td>
                        </tr>
                    ) : (
                        requests.map(request => (
                            <tr key={request.orderId} className="text-center align-item-center align-content-center">
                                <td className="text-center align-content-center col-1">  <i className="fas fa-user" style={{ marginRight: '5px' }} />{request.customerName}</td>
                                <td className="text-center align-content-center">{request.phone}</td>
                                <td className="text-center align-content-center col-2">{request.address}</td>
                                <td className="text-center align-content-center">{formatDate(request.startDate)}</td>
                                <td className="text-center align-content-center">{formatDate(request.endDate)}</td>
                                <td className="text-center align-content-center">{request.packageType}</td>
                                <td className="text-center align-content-center">{request.totalPrice.toLocaleString()}</td>
                                <td className="text-center align-content-center">{request.consultantName}</td>
                                <td className="text-center align-content-center">{request.designerName}</td>
                                <td className="text-center align-content-center">{request.constructorLeaderName}</td>
                                <td className={`text-center align-content-center col-2 ${getStatusIcon(request.status).className}`}>
                                    {getStatusIcon(request.status).icon} {request.status}
                                </td>

                            </tr>
                        ))
                    )}
                </tbody>
            </table>
        </div>
    );
};

export default Request;

