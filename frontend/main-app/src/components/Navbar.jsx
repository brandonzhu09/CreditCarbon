import React from "react";
import logo from "../assets/logo.png";
import { PrimaryNav, MenuLink, Menu, Logo } from "./NavElement";

export default function Navbar() {
  return (
    <>
      <PrimaryNav>
        <Logo to="/">
          <img src={logo} />
        </Logo>
        <Menu>
          <MenuLink to="/calculator">Calculator</MenuLink>
          <MenuLink to="/about-us">About Us</MenuLink>
          <MenuLink to="/privacy">Privacy</MenuLink>
          <MenuLink to="/works">How It Works</MenuLink>
        </Menu>
      </PrimaryNav>
    </>
  );
}
