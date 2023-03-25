import styled from 'styled-components';
import { NavLink as Link } from 'react-router-dom'

export const PrimaryNav = styled.nav`
    display: flex;
    justify-content: space-between;
    padding: 0.18rem calc((100vw - 1000px) / 2);
`

export const MenuLink = styled(Link)`
    display: flex;
    cursor: pointer;
    align-items: center;
    text-decoration: none;
    padding: 0 1.2rem;
    height: 100%;
`

export const Menu = styled.div`
    display: flex;
    align-items: center;
`