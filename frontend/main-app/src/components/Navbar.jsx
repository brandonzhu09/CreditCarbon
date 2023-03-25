import React from 'react';
import logo from '../assets/logo.png';
import { PrimaryNav, MenuLink, Menu } from './NavElement'

export default function Navbar() {
    return ( 
        <>
            <PrimaryNav>
                <Menu>
                    <MenuLink to="/">
                        Home
                    </MenuLink>
                </Menu>
            </PrimaryNav>
        </>
    )
}
