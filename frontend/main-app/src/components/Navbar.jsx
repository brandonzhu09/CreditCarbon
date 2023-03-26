import React from 'react';
import logo from '../assets/logo.png';
import { PrimaryNav, MenuLink, Menu, Logo } from './NavElement'

export default function Navbar() {
    return ( 
        <>
            <PrimaryNav>
                <Logo to="/"><img src={logo} /></Logo>
                <Menu>
                    <MenuLink class="active:bg-none hover:bg-green-500 transition duration-200" to="/calculator">Calculator</MenuLink>
                    <MenuLink class="active:bg-none hover:bg-green-500 transition duration-200"to="/about-us">About Us</MenuLink>
                    <MenuLink to="/privacy">Privacy</MenuLink>
                    <MenuLink to="/works">How it works</MenuLink>
                </Menu>
            </PrimaryNav>
        </>
    )
}
