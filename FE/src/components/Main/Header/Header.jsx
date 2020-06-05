import React from 'react';
import styled from 'styled-components'

import Logo from 'Components/Common/Logo/Logo'
import HeaderNavigation from 'Components/Main/Header/HeaderNavigation/HeaderNavigation'
import { logo } from 'Constants/mainpage'

import Cookies from 'universal-cookie';
import * as jwtDecode from 'jwt-decode';

const S = {}
S.Header = styled.div`
  position: relative;
  width: 1400px;
  height: 80px;
  color: black;
  font-size: 24px;
  margin: 0 auto;
  padding-top: 10px;
  padding-bottom: 10px;
`;

function Header() {
  function getUserNickname() {
    const cookies = new Cookies();
    const jwtToken = cookies.get('jwt');
    let userNickname = undefined;
    
    if (jwtToken !== undefined) {
      const decoded = jwtDecode(jwtToken);
      userNickname = JSON.stringify(decoded).user.nickname;
    }

    return userNickname;

    // let userNickname = '';
    // const cookies = new Cookies();

    // if (cookies.get('abc')) {
    //   const jwtToken = cookies.get('abc');
    //   const contents = {"user":{"nickname":"Han","email":"quaint3@gmail.com"}};
    //   cookies.set('abc', JSON.stringify(contents));
    //   userNickname = jwtToken.user.nickname;
    // }
    // return userNickname;
  }

  function onLogoutClick() {
    const cookies = new Cookies();
    cookies.remove('abc');
  }

  return (
      <S.Header>
        <Logo src={logo.logoImageSrc} />
        <HeaderNavigation loginUrl={process.env.REACT_APP_LOGIN_API} userNickname={getUserNickname()} onLogoutClick={onLogoutClick} />
      </S.Header>
  );
}

export default Header;