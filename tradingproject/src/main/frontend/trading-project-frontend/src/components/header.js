import React from 'react';
import { Navbar } from "react-bootstrap";
import { Container } from "react-bootstrap";
import { Nav } from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';

function Header(){
    return (
        <div className="header">
        <Navbar bg="dark" variant="dark">
        <Navbar.Brand href="#home">Trading Project</Navbar.Brand>
        <Container>
        
        <Nav className="me-auto">
          <Nav.Link href="/">Home</Nav.Link>
          <Nav.Link href="/add">Advertise</Nav.Link>
          <Nav.Link href="/charity">Charity</Nav.Link>
          <Nav.Link href="/about">About</Nav.Link>
        </Nav>
        </Container>
      </Navbar>
        </div>
      );

}
export default Header;