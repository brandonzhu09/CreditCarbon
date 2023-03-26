import styled from 'styled-components';
import { NavLink as Link } from 'react-router-dom'

export const PrimaryNav = styled.nav`
    display: flex;
    justify-content: end;
    align-items: center;
    height: 120px;
    background: #D9D9D9;
`

export const MenuLink = styled(Link)`
    align-items: center;
    text-decoration: none;
    padding: 1rem 1.2rem;
    border-radius: 10px;
    background-color: none;
    transition: 0.3s;
    &:hover,
    &:focus {
        background-color: rgba(16, 185, 129);
    }
`

export const Menu = styled.div`
    padding-right: 60px;
`

export const Logo = styled(Link)`
    flex: 2 3 0;
    padding-left: 30px;
`