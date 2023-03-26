import React from 'react';
import logo from '../assets/logo.png';
import { PrimaryNav, MenuLink, Menu } from './NavElement'

export default function Navbar() {
    return ( 
        <>
            <PrimaryNav>
                <Menu>
                    <MenuLink to="/">Home</MenuLink>
                    <MenuLink to="/calculator">Calculator</MenuLink>
                    <MenuLink to="/about-us">About Us</MenuLink>
                    <MenuLink to="/privacy">Privacy</MenuLink>
                    <MenuLink to="/works">How it works</MenuLink>
                </Menu>
            </PrimaryNav>
        </>
    )
}
