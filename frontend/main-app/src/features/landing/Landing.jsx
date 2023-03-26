import logo from '../../assets/logo.png';
import Navbar from '../../components/Navbar';

function Landing() {
    return (
        <div>
            <Navbar />
            <head>
                
                <title>CreditCarbon</title>
            </head>
            <img src={logo} alt="CreditCarbon" />
            <body>
                <h1><center>Hi there! Welcome to Credit. We convert your banking transactions into a carbon emissions value.</center></h1>
                <h2><center>Please sign into your banking accout below to find out how your spending impacts the environment. Feel free to check out our How It Works page for more info.</center></h2>
            </body>
        </div>
    )
}

export default Landing;