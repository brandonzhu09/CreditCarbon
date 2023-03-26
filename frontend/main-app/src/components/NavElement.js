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
    cursor: pointer;
    align-items: center;
    text-decoration: none;
    padding: 0 1.2rem;
`

export const Menu = styled.div`
    padding-right: 60px;
`

export const Logo = styled(Link)`
    flex: 2 3 0;
    padding-left: 30px;
`