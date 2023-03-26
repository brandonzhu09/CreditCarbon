import React from 'react';
import logo from '../../assets/logo.png';
import Navbar from '../../components/Navbar';
import '../../App.css';

function Landing() {
    return (
        <div>
            <Navbar />
            <header class="main-header max-w-screen p-20">
                <div class="text-start">
                    <h1 class="text-5xl font-bold pb-5">Welcome to CreditCarbon.</h1>
                    <h2 class="text-3xl pb-20 ">We convert your banking transactions into a carbon emissions value.</h2>
                    <h2 class="text-xl font-light">Sign into your banking account below to find out how your spending impacts the environment. Feel free to check out our <a class="font-bold" href="/works">How It Works</a> page for more info.</h2>
                </div>
            </header>
            <body>
            </body>
        </div>
    )
}

export default Landing;